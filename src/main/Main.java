package main;
import entities.Ip;
import entities.IpRange;
import entities.Network;
import extensions.NetworkExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
	
	static void firstQuestion(Scanner sc) {
		System.out.println("Digite o Endereco de rede, no Formato correto!");
		
		String text = sc.nextLine();
		
		String[] items = text.split("/");
		
    	Network n = new Network(new Ip(items[0]), Integer.parseInt(items[1]));

        Ip addrNetwork = n.addressNetwork();
        
        Ip lastIpPos = n.lastPossibleIp();
        
        System.out.println("Ip de Rede: " + addrNetwork);
        System.out.println("Ultimo Ip Possivel para a rede: "+ lastIpPos);
		
	}
	
	static void secondQuestion(Scanner sc) {
		System.out.println("Digite o Endereco de rede, no Formato correto!");
		
		String networkString = sc.nextLine();
		
		
		String[] items = networkString.split("/");
		
    	Network n = new Network(new Ip(items[0]), Integer.parseInt(items[1]));
		
    	System.out.println("Agora Digite uma Quantidade N de sub redes que deseja! Numero Inteiro pfv");
    	
		String NumberofNets = sc.nextLine();
		
		List<IpRange<Ip, Ip>> ipRanges = n.BreakNetWorkIn(Integer.parseInt(NumberofNets));
		
		System.out.println("Lista das Sub-Redes: " + ipRanges);
		
		
		
		
	}
	
	static void thirdQuestion(Scanner sc) {
		System.out.println("Digite o Endereco de rede, no Formato correto!");
		
		String networkString = sc.nextLine();
		
		
		String[] items = networkString.split("/");
		
    	Network n = new Network(new Ip(items[0]), Integer.parseInt(items[1]));
    	
    	System.out.println("Agora Digite o Ip que deseja saber se pertence a rede");
    	
		String ip = sc.nextLine();
		
		boolean ipBelongs = n.ipBelongsToNetwork(new Ip(ip));
		
		System.out.println("Se o ip pertence a rede: " + ipBelongs);
		
		
		
		
	}

	static void ForthQuestion(Scanner sc) {
		
		List<Network> networks = new ArrayList<>();
		while(true) {
			System.out.println("Digite o Endereco de Rede");
    		System.out.println("Para seguir pro proximo passo pode digitar 'pass'");
    		String networkString = sc.nextLine();
    		
    		if (networkString.equals("pass")) {
		    	break;
		    }
    		
    		
    		String[] items = networkString.split("/");
    		
    		Network n = new Network(new Ip(items[0]), Integer.parseInt(items[1]));
    		
    		networks.add(n);
    		
    		
		}
    	System.out.println("Agora Digite o Ip que deseja saber se pertence a rede");
    	
		String ip = sc.nextLine();
		
		Network ownerNetwork = NetworkExtension.ipNetworkOwner(networks, new Ip(ip));
		
		if(ownerNetwork != null) {
        	System.out.println(ownerNetwork);
        } else {
        	System.out.println("Ip nao pertencente a nenhuma das Redes");
        }
		
		
		
	}
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	while(true) {
    		System.out.println("Digite Qual Questao Deseja Resolver");
    		System.out.println("1. Questao");
    		System.out.println("2. Questao");
    		System.out.println("3. Questao");
    		System.out.println("4. Questao");
    		System.out.println("Digite apenas o numero!");
    		System.out.println("Caso Deseje Sair digite exit");
    		
    		String text = sc.nextLine();
    		
    		
    		System.out.println("Text || " + text);
    		if(text.equals("1")) {
    			firstQuestion(sc);
    		}
    		
    		if(text.equals("2")) {
    			
    			secondQuestion(sc);
    		}
    		
    		if(text.equals("3")) {
    			thirdQuestion(sc);
    		}
    		
    		if(text.equals("4")) {
    			ForthQuestion(sc);
    		}
    		
		    if (text.equals("exit")) {
		    	System.out.println("Saindo...");
		    	sc.close();
		    	break;
		    }
        }
//    	Network n = new Network(new Ip("223.20.125.27"), 29);
//
//        Ip addrNetwork = n.addressNetwork();
//        
//        Ip lastIpPos = n.lastPossibleIp();
//        
//        List<IpRange<Ip, Ip>> ipRanges = n.BreakNetWorkIn(8);
//        
//
//        boolean ipBelongs = n.ipBelongsToNetwork(new Ip("223.20.125.30"));
//        List<Network> networks = new ArrayList<>();
//        networks.add(new Network(new Ip("192.118.46.33"), 22));
//        networks.add(new Network(new Ip("192.172.45.33"), 22));
//        networks.add(new Network(new Ip("192.101.0.33"), 24));
//        networks.add(new Network(new Ip("110.161.40.33"), 24));
//        networks.add(new Network(new Ip("130.18.45.33"), 25));
//        networks.add(new Network(new Ip("223.20.125.27"), 10));
//        
//        Network ownerNetwork = NetworkExtension.ipNetworkOwner(networks, new Ip("223.20.125.30"));
//
//        System.out.println("Ip de Rede: " + addrNetwork);
//        System.out.println("Ultimo Ip Possivel para a rede: "+ lastIpPos);
//        System.out.println("Lista das Sub-Redes: " + ipRanges);
//        System.out.println("Se o ip pertence a rede: " + ipBelongs);
//        if(ownerNetwork != null) {
//        	System.out.println(ownerNetwork);
//        } else {
//        	System.out.println("Ip nao pertencente a nenhuma das Redes");
//        }
        
        System.out.println("FIM");
    }
}