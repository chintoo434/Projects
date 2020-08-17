from django.db import models

# Create your models here.
class Registrationform(models.Model):
    Fname = models.CharField(max_length=20)
    Lname = models.CharField(max_length=20)
    Uname = models.CharField(max_length=20)
    Email = models.CharField(max_length=30)
    Passwd = models.CharField(max_length=20)

