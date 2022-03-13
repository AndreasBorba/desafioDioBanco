package com.dio.desafioBanco;

public interface IOperacaoConta {

    public void sacar(double valor);

    public void depositar(double valor);

    public void transferir(Conta contaDestino, double valor);
}
