from django.shortcuts import render, redirect
from .models import Registrationform
from django.contrib import messages
from django.contrib.auth.models import User, auth
# Create your views here.
def home(request):
    return render(request, 'HTML/index.html')


def login(request):
    if(request.method=='POST'):
        Uname = request.POST['username']
        password = request.POST['password']

        user = auth.authenticate(username=Uname, password=password)
        if (user is not None):
            auth.login(request, user)
            return redirect('/oneYoga')
        else:
            messages.info(request, 'Invalid Credentails')
            return redirect('/login')
    else:
        return render(request, 'HTML/login.html')



def Logout(request):
    auth.logout(request)
    return redirect('/')



def register(request):

    if(request.method=='POST'):
        Fname = request.POST['first_name']
        Lname = request.POST['last_name']
        Uname = request.POST['username']
        email = request.POST['email']
        password1 = request.POST['password1']
        password2 = request.POST['password2']
        if(password1==password2):
            if(User.objects.filter(username=Uname).exists()):
                messages.info(request, 'User Name has been Taken')
                return redirect('/register')
            elif(User.objects.filter(email=email).exists()):
                messages.info(request, 'Email has been Taken')
                return redirect('/register')
            else:
                user=User.objects.create_user(first_name=Fname, last_name=Lname, username=Uname,
                                              email=email, password=password1)
                user.save()
                print("user created")
                return redirect('/login')

        else:
            messages.info(request, 'Password not matched')
            return redirect('/register')

    else:
        return render(request, 'HTML/register.html')






def OneYoga(request):
    if request.user.is_active:
        current_user = request.user
        username = current_user.username
        return render(request, 'HTML/oneYoga.html', {'username':username})
    else:
        return redirect('/login')

def suryaNamaskar(request):
    if request.user.is_active:
        current_user = request.user
        username=current_user.username
        #print(current_user.username)
        return render(request, 'HTML/suryaN.html', {'username':username})
    else:
        return redirect('/login')

def BikramYoga(request):
    if request.user.is_active:
        current_user = request.user
        username = current_user.username
        return render(request, 'HTML/BikramY.html', {'username':username})
    else:
        return redirect('/login')

def HathaYoga(request):
    if request.user.is_active:
        current_user = request.user
        username = current_user.username
        return render(request, 'HTML/HathaY.html', {'username':username})
    else:
        return redirect('/login')

def VinyasaYoga(request):
    if request.user.is_active:
        current_user = request.user
        username = current_user.username
        return render(request, 'HTML/VinyasaY.html', {'username':username})
    else:
        return redirect('/login')

def KundaliniYoga(request):
    if request.user.is_active:
        current_user = request.user
        username = current_user.username
        return render(request, 'HTML/KundaliniY.html', {'username':username})
    else:
        return redirect('/login')

def AnusaraYoga(request):
    if request.user.is_active:
        current_user = request.user
        username = current_user.username
        return render(request, 'HTML/anusaraY.html', {'username':username})
    else:
        return redirect('/login')

def About(request):
    if request.user.is_active:
        current_user = request.user
        return render(request, 'HTML/About.html', {'username':current_user})
    else:
        return redirect('/login')

def Users(request):
    if request.user.is_active:
        current_user = request.user
        username = current_user.username
        return render(request, 'HTML/Users.html', {'username':username})
    else:
        return redirect('/login')




def forgotpasswd(request):
    reg = Registrationform.objects.all()
    return render(request, 'HTML/forgotpasswd.html', {'r': reg})

def Registration(request):

    return render(request, 'HTML/register.html')





