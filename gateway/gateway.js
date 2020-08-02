const { ApolloServer } = require('apollo-server');
const { ApolloGateway } = require('@apollo/gateway');

var waitOn = require('wait-on');
var services = [
  { name: 'servicea', baseUrl: 'servicea:4001' },
  { name: 'serviceb', baseUrl: 'serviceb:4002' }
]

var opts = {
  resources: services.map(value => "http-get://" + value.baseUrl + "/sdl"),
  delay: 1000,
  interval: 100,
  simultaneous: 1,
  validateStatus: function (status) {
    return status >= 200 && status < 300; // default if not provided
  },
};

async function waitForServices() {
  try {
    await waitOn(opts);
  } catch (err) {
    handleError(err);
  }
}

waitForServices().then(() => {
  // Initialize an ApolloGateway instance and pass it an array of
  // your implementing service names and URLs
  const gateway = new ApolloGateway(
    {
      serviceList: services.map(value => ({
        name: value.name,
        url: "http://" + value.baseUrl + "/graphql"
      })),
    });

  // Pass the ApolloGateway to the ApolloServer constructor
  const server = new ApolloServer({
    gateway,

    // Disable subscriptions (not currently supported with ApolloGateway)
    subscriptions: false,
  });

  server.listen().then(({ url }) => {
    console.log(`🚀 Server ready at ${url}`);
  });

})