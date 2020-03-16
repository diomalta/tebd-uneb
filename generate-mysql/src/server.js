const fs = require("fs");
const faker = require("faker/locale/pt_BR");
const mysql = require("mysql");

const GENERATE_NUMBER = 100;
  
function checkAlreadyExistsFile(pathFile) {
  if (!fs.existsSync(pathFile)) {
    fs.writeFile(pathFile, '', (err) => {
      if (err) throw err;
      console.log('File is created successfully...');
    }); 
  }
}

function generateCards(number, stream, db) {
  for (let index = 0; index < number; index++) {
    const query = `INSERT INTO cards (id, number, flag, ccv, due) VALUES (${index + 1}, "${faker.phone.phoneNumber()}", "${faker.company.companyName()}", ${faker.random.number({ min: 100, max: 999 })}, "${new Date()}");`;

    stream.write(query);
    // db.query(query, (error, results, fields) => {
    //   if (error) throw error;
    //   console.log(`Insert new cards ${index + 1} into file...`);
    // });
  }
}

function generateAddress(number, stream, db) {
  for (let index = 0; index < number; index++) {
    const query = `INSERT INTO address (id, address, cep) VALUES (${index + 1}, "${faker.address.city()}", "${faker.address.countryCode()}");`;

    stream.write(query);
    // db.query(query, (error, results, fields) => {
    //   if (error) throw error;
    //   console.log(`Insert new address ${index + 1} into file...`);
    // });
  }
}

function generateParticipants(number, stream, db) {
  for (let index = 0; index < number; index++) {
    const query = `INSERT INTO participants (id, name, telephone, email, address_id, card_id, job_id) VALUES (${index + 1}, "${faker.name.findName()}", "${faker.phone.phoneNumber()}", "${faker.internet.email()}", ${faker.random.number({ min: 1, max: GENERATE_NUMBER })}, ${faker.random.number({ min: 1, max: GENERATE_NUMBER })}, ${faker.random.number({ min: 1, max: GENERATE_NUMBER })});`;
    
    stream.write(query);
    // db.query(query, (error, results, fields) => {
    //   if (error) throw error;
    //   console.log(`Insert new participant ${index + 1} into file...`);
    // });
  }
}

function startScript(pathFile) {
  const db = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'congresso'
  });

  checkAlreadyExistsFile(pathFile);

  const stream = fs.createWriteStream(pathFile);
  stream.open();

  // db.connect();
  // generate query for address
  generateAddress(GENERATE_NUMBER, stream, db);
  
  // generate query for cards
  generateCards(GENERATE_NUMBER, stream, db);

  // generate query for participants
  generateParticipants(GENERATE_NUMBER, stream, db);

  db.end();
  stream.end();
}

startScript("./script.sql");