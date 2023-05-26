const WebSocket = require('ws');

const wss = new WebSocket.Server({ port: 8080 });

wss.on('connection', (ws) => {
  ws.on('message', (message) => {
    console.log('Received: %s', message);
    
    // Generate a random 8-digit hexadecimal value
    const randomHex = Math.floor(Math.random()*0x100000000).toString(16).padStart(8, '0');

    // Append the randomHex to the received message
    const echoMessage = `${message} ${randomHex}`;

    // Echo the message back to the client
    ws.send(echoMessage);
  });

  ws.on('close', () => {
    console.log('WebSocket connection closed');
  });

  console.log('WebSocket connection established');
});

console.log('WebSocket server is running on port 8080');