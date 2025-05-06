package org.example;

public class Btree {
    private Bnode raiz;

    public Btree() {
        raiz = null;
    }

    public void addEvent(Evento e) {
        if (raiz != null) {
            raiz = raiz.addEvent(e);
        } else {
            raiz = new Bnode(e);
            System.out.println("Evento com ID " + e.getEvent_id() + " inserido com sucesso.");
        }
    }

    public void printInorder() {
        if (raiz != null) {
            raiz.printInorder();
        }
    }

    public void findEventsAtTime(int start_time) {
        if (raiz != null) {
            raiz.findEventsAtTime(start_time);
        }
    }

    public void findEventsInRange(int start_time, int end_time) {
        if (raiz != null) {
            raiz.findEventsInRange(start_time, end_time);
        }
    }

    public void removeEvent(int start_time) {
        raiz = raiz.removeEvent(raiz, start_time);
    }
}