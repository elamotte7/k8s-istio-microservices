FROM python:alpine3.7

WORKDIR /usr/local/app

RUN pip install Flask requests

COPY *.py ./

EXPOSE 9090

CMD ["python", "app.py"]
