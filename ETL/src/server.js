const app = require('./app')

const portServer = 3333

app.listen(portServer, () => {
  console.info('\u001b[34;1m' + 'Listening on port ' + portServer)
})