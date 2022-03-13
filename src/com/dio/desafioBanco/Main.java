package com.dio.desafioBanco;

public class Main {

    public static void main(String[] args) {
	    // Ativação Conta Corrente
        ContaCorrente cc = new ContaCorrente("Aderbal", "Pereira", 100);
        cc.getAgencia();
        cc.getNumero();
        // Ativação Conta Poupança
        ContaPoupanca cp = new ContaPoupanca("Jô", "Soares", 1000);
        cp.getAgencia();
        cp.getNumero();
        // Realizar transferência de CP para CC
        cc.transferir(cp, 20);
        // Realizar um depósito em CP e CC
        cc.depositar(400);
        cp.depositar(32451);
        // Consultar extrato
        cc.getExtrato();
        cp.getExtrato();


    }
}
