const express = require('express');
const cors = require('cors');

class AppController {
  constructor () {
    this.express = express();

    this.middlewares();
    this.routes();
  }

  middlewares () {
    this.express.use(cors());
    this.express.use(express.json());
  }

  routes () {
    this.express.use('/api', require('./router'))
  }
}

module.exports = new AppController().express;