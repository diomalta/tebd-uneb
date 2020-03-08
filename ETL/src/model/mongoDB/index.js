const fs = require('fs');
const path = require('path');
const mongoose = require('mongoose');

const basename  = path.basename(__filename);
let models = {};

mongoose.connection.on('error', (error) => {
  console.log(error);
});

mongoose.connection.on('open', () => {
  console.log(`[MongoDB] - Conectado ao banco de congresso`);
});

mongoose.connect(
  'mongodb://admin:123admin@ds359868.mlab.com:59868/congresso',
  {
    useNewUrlParser: true,
    useUnifiedTopology: true
  }
);

fs
  .readdirSync(__dirname)
  .filter((filename) => (filename.indexOf('.') !== 0) && (filename !== basename))
  .forEach((filename) => {
    if (filename.slice(-3) !== '.js') return;
    const filepath = path.join(__dirname, filename)
    
    const imported = (require(filepath).default) ?
      require(filepath).default :
      require(filepath);

    if (typeof imported.modelName !== 'undefined') {
      models[imported.modelName] = imported;
    }
  });

models._mongoose = mongoose;

module.exports = models;