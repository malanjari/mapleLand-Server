# nginx/Dockerfile

FROM nginx:alpine

COPY ./nginx/nginx.conf /etc/nginx/conf.d/default.conf

COPY ./frontend/dist /usr/share/nginx/html

CMD ["nginx", "-g", "daemon off;"]
