FROM node:18-alpine

# set working directory
WORKDIR /code/front/

COPY public/ /code/front/public
COPY src/ /code/front/src
COPY package.json /code/front/

RUN npm install

CMD [ "npm", "start" ]