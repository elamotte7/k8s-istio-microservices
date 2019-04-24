FROM python:2.7-alpine

WORKDIR /usr/local/app

COPY *.py ./

RUN pip install Flask requests

EXPOSE 8080

CMD ["python", "app.py"]
