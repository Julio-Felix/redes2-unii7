package main;
import entities.Ip;
import entities.IpRange;
import entities.Network;
import extensions.NetworkExtension;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Network n = new Network(new Ip("223.20.125.27"), 29);

        Ip addrNetwork = n.addressNetwork();
        
        Ip lastIpPos = n.lastPossibleIp();
        
        List<IpRange<Ip, Ip>> ipRanges = n.BreakNetWorkIn(8);
        
//        List<IpRange<Ip, Ip>> ipRanges = n.getIpRanges(4);

        boolean ipBelongs = n.ipBelongsToNetwork(new Ip("223.20.125.30"));
        List<Network> networks = new ArrayList<>();
        networks.add(new Network(new Ip("192.118.46.33"), 22));
        networks.add(new Network(new Ip("192.172.45.33"), 22));
        networks.add(new Network(new Ip("192.101.0.33"), 24));
        networks.add(new Network(new Ip("110.161.40.33"), 24));
        networks.add(new Network(new Ip("130.18.45.33"), 25));
        networks.add(new Network(new Ip("223.20.125.27"), 10));
        
        Network ownerNetwork = NetworkExtension.ipNetworkOwner(networks, new Ip("223.20.125.30"));

        System.out.println("Ip de Rede: " + addrNetwork);
        System.out.println("Ultimo Ip Possivel para a rede: "+ lastIpPos);
        System.out.println("Lista das Sub-Redes: " + ipRanges);
        System.out.println("Se o ip pertence a rede: " + ipBelongs);
        if(ownerNetwork != null) {
        	System.out.println(ownerNetwork);
        } else {
        	System.out.println("Ip nao pertencente a nenhuma das Redes");
        }
        
        System.out.println("FIM");
    }
}