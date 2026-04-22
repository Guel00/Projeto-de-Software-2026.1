from django.db import models
from django.contrib.auth.models import User

class Post(models.Model):#exemplo de herança #
    autor = models.ForeignKey(User, on_delete=models.CASCADE)
    conteudo = models.TextField(max_length=280)
    data = models.DateTimeField(auto_now_add=True)

    curtidas = models.ManyToManyField(User, related_name='curtidas', blank=True)
    dislikes = models.ManyToManyField(User, related_name='dislikes', blank=True)
    salvados = models.ManyToManyField(User, related_name='salvados', blank=True)


    republicado_de = models.ForeignKey('self', null=True, blank=True, on_delete=models.CASCADE)

class Comentario(models.Model):
    post = models.ForeignKey(Post, on_delete=models.CASCADE, related_name='comentarios')
    autor = models.ForeignKey(User, on_delete=models.CASCADE)
    texto = models.TextField()
    data = models.DateTimeField(auto_now_add=True)

    def __str__(self):
        return f'{self.autor.username} em {self.post.id}'

class Suporte(models.Model):

    usuario = models.ForeignKey(User, on_delete=models.CASCADE, null=True, blank=True)
    mensagem = models.TextField()
    data = models.DateTimeField(auto_now_add=True)


