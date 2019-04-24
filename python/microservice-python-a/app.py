#!flask/bin/python
from flask import Flask
import requests as req
from util import prefix_route, getenv

app = Flask(__name__)

app.route = prefix_route(app.route, '/service-a')

host = getenv('HOST', "0.0.0.0")
port = getenv('PORT', 8080)

@app.route('/hello')
def hello():
    return "Hello, World from  python service A v2!"

@app.route('/hello/service-b')
def hello_serviceb():
    serviceB_host = getenv("serviceB_host", "localhost")

    serviceB_http_port = getenv("serviceB_http_port", "9090")

    serviceB_context_root = getenv("serviceB_context_root", "/service-b")

    print("http://" + serviceB_host + ":" + serviceB_http_port + serviceB_context_root + "/hello")

    resp = req.get("http://" + serviceB_host + ":" + serviceB_http_port + serviceB_context_root + "/hello")

    return "The microservice B respond : ["+ resp.text + "]"

if __name__ == '__main__':
    app.run(host=host, port=port, use_reloader=True, debug=True)