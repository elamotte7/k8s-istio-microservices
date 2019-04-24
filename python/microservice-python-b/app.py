#!flask/bin/python
from flask import Flask
from util import prefix_route, getenv

app = Flask(__name__)

app.route = prefix_route(app.route, '/service-b')

host = getenv('HOST', "0.0.0.0")
port = getenv('PORT', 9090)

@app.route('/hello')
def hello():
    return "Hello, World from  python service B v2!"

if __name__ == '__main__':
    app.run(host=host, port=port, use_reloader=True, debug=True)