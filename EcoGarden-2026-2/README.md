# EcoGarden - Jogo Digital Não Violento

Projeto de Engenharia de Software 2026.2 com API Gateway, quatro microserviços e agente simbólico de recomendação.

**Código completo:** disponibilizado no pacote ZIP entregue na conversa. Para concluir a publicação, enviar o conteúdo da pasta `ecogarden_microservices` para esta pasta `EcoGarden-2026-2` do repositório.

## Como executar

```bash
pip install -r requirements.txt
python run_local.py
```

Abrir http://127.0.0.1:8000.

## Componentes

- API Gateway :8000
- Game Service :5001
- Profile Service :5002
- Recommendation Service :5003
- Achievement Service :5004
- Componente reutilizável `shared/http_client.py`

O Agente Jardineiro é uma IA simbólica baseada em regras, não um modelo generativo.
