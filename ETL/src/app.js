const express = require('express');
const cors = require('cors');

// const Participant = require('./service/participants')

class AppController {
  constructor () {
    this.express = express();

    this.middlewares();
    this.routes();
    this.action();
  }

  middlewares () {
    this.express.use(cors());
    this.express.use(express.json());
  }

  routes () {
    this.express.use('/api', require('./router'))
  }

  async action() {
    // await Participant.transfersToMongoDB();
  }
}

module.exports = new AppController().express;