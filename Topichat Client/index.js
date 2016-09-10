/*

    This is the official web distribution for Topichat.
    You can find the project at https://github.com/MightyElemental/Topichat/



    ISC License

    Copyright (c) 2016, Noé Nogueira Martins & James Burnell

    Permission to use, copy, modify, and/or distribute this software for any purpose with or without fee is hereby granted, provided that the above copyright notice and this permission notice appear in all copies.

    THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.

*/

"use strict";

const express = require("express");
const fs = require("fs");
const app = express();

/* The Topichat class */
class Topichat {
    /* [Promise] generate a file based on parameters. */
    static generateFile(params) {
        var promise = new Promise((resolve, reject) => {
            

            /* Read the base file */
            fs.readFile(__dirname + "/render/base.html", (err, data) => {
                if (err) { 
                    reject(err);
                }else{
                    var file = data.toString();

                    /* Expression for parameter replacement */
                    var exp = new RegExp("\<\%\=([A-z]+)\%\>", "gi");

                    var match;
                    while((match = exp.exec(file)) != undefined) {
                        file = file.replace(match[0], params[match[1]]);
                    }

                    resolve(file);
                }
            });
        });

        return promise;
    }
}



/* 
    There is no standard '/' directory in Topichat, the homepage is /r/hat 
    where more help is provided by bots. 
*/

app.get("/", (req, res) => {
    res.redirect("/r/hat");
});


/* When a user requests /r/:sub/ we will generate a file for them */
app.get("/r/:sub/", (req, res) => {
    
    var params = {
        sub: req.params.sub
    };

    Topichat.generateFile(params).then((html) => {
        res.send(html);
    }).catch((err) => {
        res.send(err.toString());
    });

});


/* Start listening for GETs */
app.listen(process.env.port || 80);