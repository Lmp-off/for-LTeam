const Discord = require('discord.js');
const client = new Discord.Client();
let config = require("./botconfig.json");
let token = config.token;
let prefix=config.prefix;

client.on('ready', () => {
  console.log(`Logged in as ${client.user.tag}!`);
});

client.on('message', msg => {
  if (msg.content === 'ping') {
    msg.reply('Pong!');
  }
});

client.login(token);