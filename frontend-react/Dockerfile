FROM node:14-alpine AS app-development
ENV NODE_ENV development
WORKDIR /app/front
COPY package*.json ./
RUN npm install
COPY . .
EXPOSE 3000
CMD [ "npm", "run", "start.dev"]

FROM node:14-alpine AS app-builder
ENV NODE_ENV production
WORKDIR /app/front
COPY package*.json ./
RUN npm install --production
COPY . .
RUN npm run build

FROM nginx:1.21.0-alpine AS app-production
ENV NODE_ENV production
COPY --from=app-builder /app/front/build /usr/share/nginx/html
COPY ./nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]