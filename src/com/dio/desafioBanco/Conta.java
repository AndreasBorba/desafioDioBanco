package com.dio.desafioBanco;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IOperacaoConta {

    private static final int AGENCIA_PADRAO = 1525;
    private static int numeroContaRandom;

    protected Cliente cliente;
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected List<String> extrato = new ArrayList<>();

    public Conta(String nome, String sobrenome, double saldoAtivacao) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = numeroContaRandom += 1;
        this.saldo = saldoAtivacao;
        this.cliente = new Cliente(nome, sobrenome);
    }

    @Override
    public void sacar(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
            this.extrato.add(" - Saque realizado, valor: R$ " + valor + " reais");
        } else {
            System.out.println("Saldo indisponível");
            this.extrato.add(" - Saque não realizado, saldo indisponível.");
        }
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Depósito realizado com sucesso.");
        this.extrato.add(" - Depósito no valor de R$ " + valor + " reais, realizado com sucesso.");
    }

    @Override
    public void transferir(Conta contaDestino, double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
            contaDestino.saldo += valor;
            System.out.println("Transferência realizada com sucesso.");
            this.extrato.add(" - Transferência no valor de R$ " + valor + " reais, realizada com sucesso.");
            contaDestino.extrato.add(" - Transferência recebida no valor de R$ "+valor+" reais.");
        } else {
            System.out.println("Saldo indisponível");
            this.extrato.add(" - Transferência não realizada, saldo indisponível.");
        }
    }

    public int getAgencia() {
        return agencia;
    }


    public int getNumero() {
        return numero;
    }


    public double getSaldo() {
        return saldo;
    }

    public void getExtrato() {
        System.out.println("========================");
        System.out.println("=== Extrato da conta ===");
        System.out.println("Nome: "+this.cliente.getNome()+" "+this.cliente.getSobrenome());
        System.out.println("Número da Conta: "+this.numero+"\nNúmero da Agência: "+this.agencia+"\nSaldo: "+this.saldo);
        for (int i = 0; i < this.extrato.size(); i++) {
            System.out.println(extrato.get(i));
        }
        System.out.println("========================");
    }
}

