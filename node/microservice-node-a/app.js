'use strict';

const express = require("express");
const http = require("http");

// Constants
const PORT = process.env.PORT || 8080;
const HOST = process.env.HOST || '0.0.0.0';
const CONTEXT_PATH = process.env.CONTEXT_PATH || '/service-a';

const serviceB_host = process.env.serviceB_host || 'localhost';
const serviceB_http_port = process.env.serviceB_http_port || 9090;
const serviceB_context_root = process.env.serviceB_context_root || '/service-b';

// App
const app = express();
const router = express.Router();

let message = "NONE";

function hello(res) {
  return http.get({
    host: serviceB_host,
    port: serviceB_http_port,
    path: `${serviceB_context_root}/hello`
  }, function (response) {
    // Continuously update stream with data
    var body = '';
    response.on('data', function (d) {
      body += d;
    });
    response.on('end', function () {
      res.send("Service B says : [" + body + "]");
    });
  });
};

router.get('/hello', (req, res) => {
  res.send('Hello World from microservice Node.js A v2!\n');
});

router.get("/hello/service-b", (req, res, next) => {
  hello(res);
});

app.use(CONTEXT_PATH, router);

app.listen(PORT, HOST);
console.log(`Running on http://${HOST}:${PORT}${CONTEXT_PATH}`);