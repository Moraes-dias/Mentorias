# 🛠️ Guia Prático: Principais Comandos e Flags do Git

Este guia serve como uma consulta rápida para os comandos mais utilizados no dia a dia de desenvolvimento.

---

## 1. Configuração Inicial e Status

*   **`git init`**
    *   *O que faz:* Transforma uma pasta local comum em um repositório Git monitorado.
*   **`git status`**
    *   *O que faz:* Mostra o estado atual do seu repositório (quais arquivos foram modificados, quais estão prontos para commit, etc.). **Use isso o tempo todo.**
*   **`git remote add origin url`** Adiciona o repositorio remoto ao repositorio local
---

## 2. Ciclo de Vida do Código (Add, Commit, Push)

*   **`git add <arquivo>`** ou **`git add .`**
    *   *O que faz:* Prepara os arquivos modificados (área de *staging*) para serem salvos.
    *   *Flag `.`:* Adiciona **todos** os arquivos modificados da pasta atual.
*   **`git commit -m "mensagem descritiva"`**
    *   *O que faz:* Salva oficialmente as alterações preparadas no histórico local com uma mensagem explicando o que foi feito.
*   **`git push <remoto> <branch>`**
    *   *O que faz:* Envia os seus commits locais para o repositório remoto (ex: GitHub).
    *   *Exemplo:* `git push origin main`

---

## 3. Sincronização (Atualizando o Código)
 
*   **`git clone <url>`**
    *   *O que faz:* Baixa uma cópia inteira de um repositório remoto existente para a sua máquina.
*   **`git pull`**
    *   *O que faz:* Baixa as atualizações mais recentes do repositório remoto e já aplica (faz o *merge*) na sua branch atual.
*   **`git fetch --all`**
    *   *O que faz:* Baixa as informações do repositório remoto, mas **não** mexe no seu código local (ótimo para verificar o que mudou antes de atualizar de fato).
    *   *Flag --all:* Baixa de todas as branches.

---

## 4. Branches (Ramificações)

*   **`git branch`**
    *   *O que faz:* Lista todas as branches locais e mostra em qual você está no momento.
*   **`git checkout -b <nome-da-branch>`**
    *   *O que faz:* Cria uma nova branch e já muda automaticamente para ela.
*   **`git checkout <nome-da-branch>`** (ou **`git switch <nome>`**)
    *   *O que faz:* Alterna entre branches existentes.

---

## 5. Histórico e Inspeção

*   **`git log`**
    *   *O que faz:* Mostra o histórico detalhado de todos os commits feitos na branch.
    *   *Flag útil:* `git log --oneline` (mostra o histórico de forma resumida, uma linha por commit).
*   **`git diff`**
    *   *O que faz:* Mostra exatamente quais linhas de código você alterou, mas ainda não adicionou ao `add`.