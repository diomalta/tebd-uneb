module.exports = {
  host: 'localhost', //mariadb
  username: 'root',
  password: '123456',
  database: 'congresso',
  dialect: 'mariadb',
  port: 3306,
  storage: '',
  logging: false,
  define: {
    timestamps: false,
    underscored: false,
    underscoredAll: false,
    paranoid: false
  }
}