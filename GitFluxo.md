# 🌿 Fluxo de Trabalho com Git (Git Workflow)

Trabalhar em equipe exige organização para evitar conflitos de código e garantir que a aplicação principal (`main`) permaneça sempre estável e funcionando. O fluxo mais utilizado no mercado (baseado no *Git Flow simplificado* ou *Feature Branch Workflow*) segue os princípios abaixo.

---

## 1. A Estrutura de Branches

Para manter o projeto organizado, utilizamos três tipos principais de branches:

*   **`main` (ou `master`)**: É a branch principal de produção. **Ninguém comita diretamente nela.** Todo código aqui deve estar testado, funcional e pronto para ir para o ar. Aqui eh terra sagrada, ninguem alem do scrum master mexe nela, ah nao ser que vc precise corrijir um erro absurdo.
*   **`develop` (opcional em projetos menores)**: Branch onde juntamos todas as funcionalidades desenvolvidas antes de irem para produção. Normalmente no maximo duas pessoas mexem aqui diretamente, sendo ela o lider de equipe, e o scrum master.
*   **`feature/nome-da-funcionalidade`**: É a branch onde **você** vai trabalhar. Cada nova tarefa ou funcionalidade ganha a sua própria branch, criada a partir da `main`. exemplo de nome da branch: feat-tela-login

---

## 2. O Passo a Passo do Fluxo Diário (Evitando Estragar o Código dos Outros)

Para garantir que você não sobrescreva o código de ninguém e trabalhe com segurança, siga religiosamente e rigorosamente este ciclo:

### Passo 1: Atualize sua branch local
Antes de começar qualquer alteração, certifique-se de que sua máquina tem a versão mais recente do projeto remoto.
```bash
git checkout main (ou branch mais atualizada)
git pull origin main (ou branch mais atualizada)
```
lembrando que nem sempre a `main` vai estar 100% atualizada entao eh bom que vc veja qual foi o ultimo commit de uma branch q tem relacao com a feature q vc estara desenvolvendo

### Passo 2: Crie uma branch para a sua tarefa
Nunca desenvolva na `main`. Crie uma branch específica para o que você vai fazer:
```bash
git checkout -b feature/login-usuario
```
*(A flag `-b` cria a branch e já muda para ela).*

### Passo 3: Faça seus commits de forma consciente
Escreva códigos que funcionem e faça commits atómicos e descritivos:
```bash
git add .
git commit -m "feat: adiciona formulário de login na página inicial"
e nao
git commit -m "amem senhor finalmente funcionou"
```

### Passo 4: Sincronize com o repositório remoto sem medo
Verifique se vc esta na branch certa com:
```bash
git branch
```
verifique se os arquivos no commit estao corretos:

```bash
git status
```
Envie sua branch para o GitHub:
```bash
git push origin feature/login-usuario
```

### Passo 5: Abra o Pull Request (PR)
*   Vá até o repositório no GitHub.
*   Abra um **Pull Request** da sua branch (`feature/login-usuario`) para a branch desenvolvimento (`dev`).
*   **Quem faz o merge?** Idealmente, um colega de equipe(normalmente o scrum master) faz o *code review* (revisão de código) e aprova. Após a aprovação, o scrum master vai fazer o merge no local dele e fazer um push na branch q estara recebendo o merge
*   Com o pull request ja aberto, vc vai abrir sua IDE, vai fazer um pull da branch q esta enviando o codigo

Usando o seguinte exemplo:

feat-login(head) abriu um pull request para dev(base)
na sua IDE, vc vai mudar pra branch feat-login, fazer um pull da feat-login e mudar pra branch dev e fazer um pull dela
Na branch dev vc usara 
```bash
git merge feat-login
```
esse comando faz o merge de duas branches locais
depois de resolver possiveis conflitos eh so fazer um commit e um push que automaticamente o PR vai se fechar no github
---

## 3. Boas Práticas de Ouro para Evitar Conflitos

1.  **Faça `pull` com frequência:** Antes de começar o dia e antes de subir código novo, puxe as atualizações da branch mais atualizada.
2.  **Comunique a equipe:** Se for mexer em um arquivo crítico que outra pessoa também mexe, avisem-se.
3.  **Nunca force um push perigoso:** Evite usar `git push -f` na `main`. Isso pode apagar o trabalho dos outros.