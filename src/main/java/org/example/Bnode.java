package org.example;

public class Bnode {

    private Evento x;
    private Bnode esq, dir;
    private int altura;

    public Bnode(Evento e) {
        x = new Evento(e);
        this.esq = this.dir = null;
        this.altura = 0;
    }

    private int alt(Bnode no) {
        if (no != null) {
            return no.altura;
        }
        return -1;
    }

    private void atualizaAlt() {
        int altE = alt(esq);
        int altD = alt(dir);
        altura = Math.max(altE, altD) + 1;
    }

    private int fatorBalanceamento() {
        return alt(dir) - alt(esq);
    }

    private Bnode giraDireita() {
        Bnode temp = esq;
        esq = temp.dir;
        temp.dir = this;

        atualizaAlt();
        temp.atualizaAlt();

        return temp;
    }

    private Bnode giraEsquerda() {
        Bnode temp = dir;
        dir = temp.esq;
        temp.esq = this;

        atualizaAlt();
        temp.atualizaAlt();

        return temp;
    }

    private Bnode rebal() {
        atualizaAlt();
        int fb = fatorBalanceamento();

        if (fb < -1) {
            if (esq.fatorBalanceamento() <= 0) {
                return giraDireita();
            } else {
                esq = esq.giraEsquerda();
                return giraDireita();
            }
        }

        if (fb > 1) {
            if (dir.fatorBalanceamento() >= 0) {
                return giraEsquerda();
            } else {
                dir = dir.giraDireita();
                return giraEsquerda();
            }
        }

        return this;
    }

    public Bnode addEvent(Evento e) {
        if (verificarSobreposicao(e)) {
            System.out.println("Erro: Evento com ID " + e.getEvent_id() + " tem horário sobreposto com outro evento.");
            return this;
        }

        if ((e.getEvent_id()) <= x.getEvent_id()) {
            if (esq != null) {
                esq = esq.addEvent(e);
            } else {
                System.out.println("Evento com ID " + e.getEvent_id() + " inserido com sucesso.");
                esq = new Bnode(e);
            }
        } else {
            if (dir != null) {
                dir = dir.addEvent(e);
            } else {
                System.out.println("Evento com ID " + e.getEvent_id() + " inserido com sucesso.");
                dir = new Bnode(e);
            }
        }

        return rebal();
    }

    public void printInorder() {
        if (esq != null) {
            esq.printInorder();
        }
        System.out.print("ID: " + x.getEvent_id() + ", descrição: " + x.getDescription() + ", Inicio:"
                + x.getStart_time() + ", Fim:" + x.getEnd_time());
        System.out.println();

        if (dir != null) {
            dir.printInorder();
        }
    }

    public void findEventsAtTime(int start_time) {
        if (x.getStart_time() == start_time) {
            System.out.println("ID: " + x.getEvent_id() + ", descrição: " + x.getDescription() + ", Inicio:"
                    + x.getStart_time() + ", Fim:" + x.getEnd_time());
        }
        if (esq != null) {
            esq.findEventsAtTime(start_time);
        }
        if (dir != null) {
            dir.findEventsAtTime(start_time);
        }
    }

    public void findEventsInRange(int start_time, int end_time) {
        if (start_time >= x.getStart_time() && end_time <= x.getEnd_time()) {
            System.out.print("ID: " + x.getEvent_id() + ", descrição: " + x.getDescription() + ", Inicio:"
                    + x.getStart_time() + ", Fim:" + x.getEnd_time());
        } else {
        }
        if (esq != null) {
            esq.findEventsInRange(start_time, end_time);
        }
        if (dir != null) {
            dir.findEventsInRange(start_time, end_time);
        }
    }

    public Bnode removeEvent(Bnode node, int start_time) {
        if (node == null)
            return null;

        if (start_time < node.x.getStart_time()) {
            node.esq = removeEvent(node.esq, start_time);
        } else if (start_time > node.x.getStart_time()) {
            node.dir = removeEvent(node.dir, start_time);
        } else {
            // Encontrou o nó a remover
            if (node.esq == null)
                return node.dir;
            else if (node.dir == null)
                return node.esq;

            node.x = minValor(node.dir);
            node.dir = removeEvent(node.dir, node.x.getStart_time());
        }

        return node.rebal();
    }

    private Evento minValor(Bnode node) {
        Evento min = node.x;
        while (node.esq != null) {
            min = node.esq.x;
            node = node.esq;
        }
        return min;
    }

    public boolean verificarSobreposicao(Evento novoEvento) {
        if (novoEvento.getStart_time() < x.getEnd_time() && novoEvento.getEnd_time() > x.getStart_time()) {
            return true;
        }

        if (esq != null && novoEvento.getStart_time() < x.getStart_time()) {
            return esq.verificarSobreposicao(novoEvento);
        }
        if (dir != null && novoEvento.getStart_time() >= x.getStart_time()) {
            return dir.verificarSobreposicao(novoEvento);
        }

        return false;
    }
}