const mongoClient = require('mongodb').MongoClient;
const sqlClient = require('mysql');

// local MongoDB connection
const mongoConnectionInstance;

// remote sqlite connection
const sqlConnectionInstance;

exports.mongoDB = {
    // default mongodb connection
    url: 'mongodb+srv://diohmalta@gmail.com:d988004199s@cluster0-ddulw.mongodb.net/test?retryWrites=true&w=majority',
    connection : function (callback) {
      if (mongoConnectionInstance) {
          callback(mongoConnectionInstance);
          return;
      }

      mongoClient.connect(this.url, function(error, databaseConnection) {
          if (error) throw new Error(error);
          mongoConnectionInstance = databaseConnection;
          callback(databaseConnection);
      });
    }
};

exports.sqlDB = {
    // required sql url string
    url: null,
    connection: function (callback) {
      if (sqlConnectionInstance) {
          callback(sqlConnectionInstance);
          return;
      };

      if (!this.url) {
          throw new Error("Remote url connection string required.")
      } else {
          RemoteClient.connect(this.url, function (error, databaseConnection) {
              if (error) throw new Error(error);
              sqlConnectionInstance = databaseConnection;
              callback(databaseConnection);
          });
      }
    }
};