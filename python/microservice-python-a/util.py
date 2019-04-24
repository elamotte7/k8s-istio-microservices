#!flask/bin/python
import os
def prefix_route(route_function, prefix='', mask='{0}{1}'):
  '''
    Defines a new route function with a prefix.
    The mask argument is a `format string` formatted with, in that order:
      prefix, route
  '''
  def newroute(route, *args, **kwargs):
    '''New function to prefix the route'''
    return route_function(mask.format(prefix, route), *args, **kwargs)
  return newroute

def getenv(key, fallback):
    value = os.environ.get(key)
    if not value:
        return fallback
    return value
