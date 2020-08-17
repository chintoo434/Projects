# write code here

from django.urls import path
from . import views

app_name = 'aapOne'

urlpatterns = [
    path('', views.home, name='home-page'),
    path('login', views.login, name="login"),
    path('register', views.register, name="register"),
    path('forgotpasswd', views.forgotpasswd, name="forgotpasswd"),
    path('registration', views.Registration, name="Registration"),

    path('oneYoga', views.OneYoga, name="oneYoga"),
    path('suryaNamaskar', views.suryaNamaskar, name="suryaNamaskar"),
    path('BikramYoga', views.BikramYoga, name="BikramYoga"),
    path('HathaYoga', views.HathaYoga, name="HathaYoga"),
    path('VinyasaYoga', views.VinyasaYoga, name="VinyasaYoga"),
    path('KundaliniYoga', views.KundaliniYoga, name="KundaliniYoga"),
    path('AnusaraYoga', views.AnusaraYoga, name="AnusaraYoga"),
    path('About', views.About, name="About"),
    path('Users', views.Users, name="User"),
    path('Logout', views.Logout, name="Logout"),
]