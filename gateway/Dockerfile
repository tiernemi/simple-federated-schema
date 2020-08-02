FROM node
WORKDIR /usr/src/app
COPY package*.json ./
COPY gateway.js ./
RUN npm install
CMD ["npm", "run", "start"]
