package main;
import entities.Ip;
import entities.IpRange;
import entities.Network;
import extensions.NetworkExtension;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Network n = new Network(new Ip("223.20.125.27"), 27);

        Ip addrNetwork = n.addressNetwork();
        
        Ip lastIpPos = n.lastPossibleIp();
        
        List<IpRange<Ip, Ip>> ipRanges = n.BreakNetWorkIn(7);
        
        System.out.println(addrNetwork);
        System.out.println(lastIpPos);
        System.out.println(ipRanges);
//        List<IpRange<Ip, Ip>> ipRanges2 = n.getIpRanges(4);
//
//        boolean ipBelongs = n.ipBelongsToNetwork(new Ip("192.168.45.1"));
//
//        List<Network> networks = new ArrayList<>();
//        networks.add(new Network(new Ip("192.168.46.33"), 24));
//        networks.add(new Network(new Ip("192.168.45.33"), 26));
//        networks.add(new Network(new Ip("192.168.0.33"), 24));
//        networks.add(new Network(new Ip("192.168.40.33"), 24));
//        networks.add(new Network(new Ip("192.168.45.33"), 25));
//        networks.add(new Network(new Ip("192.168.45.33"), 24));
//
//        Network ownerNetwork = NetworkExtension.ipNetworkOwner(networks, new Ip("192.168.45.255"));

        System.out.println("FIM");
    }
}