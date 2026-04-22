from django.shortcuts import render, redirect
from .models import Post, Comentario, Suporte
from django.contrib.auth.decorators import login_required
from django.contrib.auth.forms import UserCreationForm
from django.contrib.auth import login

@login_required
def feed(request):
    posts = Post.objects.all().order_by('-data')
    return render(request, 'core/feed.html', {'posts': posts})

def criar_post(request):
    if request.method == "POST":
        conteudo = request.POST.get('conteudo')
        Post.objects.create(autor=request.user, conteudo=conteudo)
    return redirect('feed')

def curtir_post(request, post_id):
    post = Post.objects.get(id=post_id)
    if request.user in post.curtidas.all():
        post.curtidas.remove(request.user)
    else:
        post.curtidas.add(request.user)
        post.dislikes.remove(request.user)
    return redirect('feed')

def dislike_post(request, post_id):
    post = Post.objects.get(id=post_id)
    if request.user in post.dislikes.all():
        post.dislikes.remove(request.user)
    else:
        post.dislikes.add(request.user)
        post.curtidas.remove(request.user)
    return redirect('feed')

def republicar(request, post_id):
    original = Post.objects.get(id=post_id)
    Post.objects.create(autor=request.user, conteudo=original.conteudo, republicado_de=original)
    return redirect('feed')

def comentar(request, post_id):
    if request.method == "POST":
        texto = request.POST.get('texto')
        post = Post.objects.get(id=post_id)
        Comentario.objects.create(autor=request.user, post=post, texto=texto)
    return redirect('feed')

def suporte_view(request):
    sucesso = False
    if request.method == "POST":
        mensagem = request.POST.get('mensagem')
        assunto = request.POST.get('assunto')

        usuario_logado = request.user if request.user.is_authenticated else None

        Suporte.objects.create(
            usuario=usuario_logado,
            mensagem=f"Assunto: {assunto} | Mensagem: {mensagem}"
        )
        sucesso = True
    return render(request, 'core/suporte.html', {'sucesso': sucesso})

def deletar_post(request, post_id):
    post = Post.objects.filter(id=post_id, autor=request.user)
    if post.exists():
        post.delete()
    return redirect('feed')

def cadastro(request):
    if request.method == 'POST':
        form = UserCreationForm(request.POST)
        if form.is_valid():
            user = form.save() #exemplo de encapsulamento#
            login(request, user)
            return redirect('feed')
    else:
        form = UserCreationForm()
    return render(request, 'core/cadastro.html', {'form': form})


