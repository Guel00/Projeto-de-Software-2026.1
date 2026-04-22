from django.urls import path
from . import views 
from django.contrib.auth import views as auth_views

urlpatterns = [
    path('', views.feed, name='feed'),
    path('login/', auth_views.LoginView.as_view(template_name='core/login.html'), name='login'),
    path('logout/', auth_views.LogoutView.as_view(), name='logout'),
    path('criar/', views.criar_post, name='criar_post'),
    path('deletar/<int:post_id>/', views.deletar_post, name='deletar_post'), 
    path('curtir/<int:post_id>/', views.curtir_post, name='curtir'),
    path('dislike/<int:post_id>/', views.dislike_post, name='dislike'),
    path('republicar/<int:post_id>/', views.republicar, name='republicar'),
    path('comentar/<int:post_id>/', views.comentar, name='comentar'),
    path('suporte/', views.suporte_view, name='suporte'),
    path('cadastro/', views.cadastro, name='cadastro'),
]