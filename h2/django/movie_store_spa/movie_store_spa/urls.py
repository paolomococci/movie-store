from django.conf.urls import url
from django.contrib import admin

urlpatterns = [
    path('polls/', include('polls.urls')),
    url(r'^admin/', admin.site.urls)
]
