from django.conf.urls import url
from django.contrib import admin
#from django.urls import include, path
#from django.conf.urls import url, include

urlpatterns = [
    #path(r'^polls/', include('polls.urls')),
    url(r'^admin/', admin.site.urls)
]
