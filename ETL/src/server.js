const app = require('./app')

const portServer = process.env.PORT_SERVER|| 3333

app.listen(portServer, () => {
  console.info('\u001b[34;1m' + 'Listening on port ' + portServer)
})