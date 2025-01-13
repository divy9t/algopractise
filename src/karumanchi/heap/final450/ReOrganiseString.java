package karumanchi.heap.final450;

import java.util.HashMap;
import java.util.PriorityQueue;


public class ReOrganiseString {
    public static void main(String[] args) {
        String s = "tndsewnllhrtwsvxenkscbivijfqnysamckzoyfnapuotmdexzkkrpmppttficzerdndssuveompqkemtbwbodrhwsfpbmkafpwyedpcowruntvymxtyyejqtajkcjakghtdwmuygecjncxzcxezgecrxonnszmqmecgvqqkdagvaaucewelchsmebikscciegzoiamovdojrmmwgbxeygibxxltemfgpogjkhobmhwquizuwvhfaiavsxhiknysdghcawcrphaykyashchyomklvghkyabxatmrkmrfsppfhgrwywtlxebgzmevefcqquvhvgounldxkdzndwybxhtycmlybhaaqvodntsvfhwcuhvuccwcsxelafyzushjhfyklvghpfvknprfouevsxmcuhiiiewcluehpmzrjzffnrptwbuhnyahrbzqvirvmffbxvrmynfcnupnukayjghpusewdwrbkhvjnveuiionefmnfxao";
        StringBuilder output = new StringBuilder();

        HashMap<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
           charCount.putIfAbsent(s.charAt(i), 0);
           charCount.put(s.charAt(i), charCount.get(s.charAt(i)) + 1);
        }

        // Check if reorganization is possible
        int maxFrequency = (s.length() + 1) / 2;
        for (int count : charCount.values()) {
            if (count > maxFrequency) {
                System.out.println("Impossible to reorganize");
                return;
            }
        }

        PriorityQueue<Character> priorityQueue = new PriorityQueue<>((a, b) -> charCount.get(b) - charCount.get(a));

        priorityQueue.addAll(charCount.keySet());

        Character lastAddedString = ' ';
        while (!priorityQueue.isEmpty()) {
            Character current = priorityQueue.poll();
            if (!lastAddedString.equals(current)) {
                output.append(current);
                lastAddedString = current;
                charCount.put(current, charCount.get(current) - 1);
                if (charCount.get(current) > 0) {
                    priorityQueue.add(current);
                }
            } else {
                Character peek = priorityQueue.poll();
                output.append(peek);
                lastAddedString = peek;
                charCount.put(peek, charCount.get(peek) - 1);
                if (charCount.get(peek) > 0) {
                    priorityQueue.add(peek);
                }
                priorityQueue.add(current);
            }

        }


        System.out.println(output);
    }
}
