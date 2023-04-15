FROM node:14-alpine

# Build stage
FROM node:14 as build-stage

WORKDIR /app

COPY package.json ./

RUN npm install

COPY . .

RUN npm run build

# Production stage
FROM nginx:1.19

COPY --from=build-stage /app/build /usr/share/nginx/html

COPY nginx.conf /etc/nginx/conf.d/default.conf

