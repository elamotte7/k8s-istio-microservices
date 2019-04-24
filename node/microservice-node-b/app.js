'use strict';

const express = require("express");

// Constants
const PORT = process.env.PORT || 9090;
const HOST = process.env.HOST || '0.0.0.0';
const CONTEXT_PATH = process.env.CONTEXT_PATH || '/service-b';

// App
const app = express();
const router = express.Router();

router.get('/hello', (req, res) => {
  res.send('Hello World from microservice Node.js B v2!\n');
});

app.use(CONTEXT_PATH, router);

app.listen(PORT, HOST);
console.log(`Running on http://${HOST}:${PORT}${CONTEXT_PATH}`);