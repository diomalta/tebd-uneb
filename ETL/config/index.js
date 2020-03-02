exports.sql = {
  host: '127.0.0.1',
  username: 'root',
  password: '',
  database: 'congresso',
  dialect: 'mariadb',
  port: 3306,
  storage: '',
  logging: false,
  define: {
    timestamps: true,
    underscored: true,
    underscoredAll: true,
    paranoid: true
  }
}

exports.mongo = {};