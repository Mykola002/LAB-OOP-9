package ua.opnu;

import java.util.*;

public class Task {


    // ЗАВДАННЯ 1: Видалення коротшого рядка з пари

    public void removeShorterStrings(List<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            String first = list.get(i);
            String second = list.get(i + 1);

            if (first.length() < second.length()) {
                list.remove(i);
                i--;
            } else if (second.length() < first.length()) {
                list.remove(i + 1);
                i--;
            } else {
                list.remove(i);
                i--;
            }
        }
    }


    // ЗАВДАННЯ 2: Дублювання кожного рядка

    public void stutter(List<String> list) {
        for (int i = 0; i < list.size(); i += 2) {
            list.add(i, list.get(i));
        }
    }


    // ЗАВДАННЯ 3: Попарна зміна елементів місцями

    public void switchPairs(List<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            String temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }
    }


    // ЗАВДАННЯ 4: Видалення дублікатів з відсортованого списку

    public void removeDuplicates(List<String> list) {
        Iterator<String> iterator = list.iterator();
        if (!iterator.hasNext()) return;

        String previous = iterator.next();
        while (iterator.hasNext()) {
            String current = iterator.next();
            if (current.equals(previous)) {
                iterator.remove();
            } else {
                previous = current;
            }
        }
    }


    // ЗАВДАННЯ 5: Додавання "****" перед рядками довжиною 4

    public void markLength4(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i++;
            }
        }
    }


    // ЗАВДАННЯ 6: Перевірка черги на паліндром

    public boolean isPalindrome(Queue<Integer> queue) {
        if (queue == null || queue.isEmpty()) {
            return true;
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();
        boolean isPal = true;

        for (int i = 0; i < size; i++) {
            int n = queue.poll();
            stack.push(n);
            queue.add(n);
        }

        for (int i = 0; i < size; i++) {
            int n = queue.poll();
            int fromStack = stack.pop();
            if (n != fromStack) {
                isPal = false;
            }
            queue.add(n);
        }

        return isPal;
    }


    // ЗАВДАННЯ 7: Переупорядкування черги за зростанням

    public void reorder(Queue<Integer> queue) {
        if (queue == null || queue.isEmpty()) return;
        ArrayDeque<Integer> negatives = new ArrayDeque<>();
        ArrayDeque<Integer> positives = new ArrayDeque<>();

        while (!queue.isEmpty()) {
            int n = queue.poll();
            if (n < 0) {
                negatives.push(n);
            } else {
                positives.add(n);
            }
        }

        while (!negatives.isEmpty()) {
            queue.add(negatives.pop());
        }
        while (!positives.isEmpty()) {
            queue.add(positives.poll());
        }
    }


    // ЗАВДАННЯ 8: Парні спереду, непарні ззаду

    public void rearrange(Queue<Integer> queue) {
        if (queue == null || queue.isEmpty()) return;

        ArrayDeque<Integer> evens = new ArrayDeque<>();
        ArrayDeque<Integer> odds = new ArrayDeque<>();

        while (!queue.isEmpty()) {
            int n = queue.poll();
            // У Java залишок від ділення на 2 для від'ємних чисел може бути -1.
            // Число є парним, якщо n % 2 == 0 (це покриває і додатні, і від'ємні, і 0).
            if (n % 2 == 0) {
                evens.add(n);
            } else {
                odds.add(n);
            }
        }

        // Збираємо назад у чергу: спочатку всі парні, потім усі непарні
        while (!evens.isEmpty()) {
            queue.add(evens.poll());
        }
        while (!odds.isEmpty()) {
            queue.add(odds.poll());
        }
    }

    // ЗАВДАННЯ 9: Довжина найдовшого рядка у Set

    public int maxLength(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return 0;
        }
        int max = 0;
        for (String s : set) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }


    // ЗАВДАННЯ 10: Видалення рядків парної довжини

    public void removeEvenLength(Set<String> set) {
        if (set != null) {
            set.removeIf(s -> s.length() % 2 == 0);
        }
    }


    // ЗАВДАННЯ 11: Кількість унікальних спільних елементів

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        if (list1 == null || list2 == null) return 0;
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);
        set1.retainAll(set2);
        return set1.size();
    }


    // ЗАВДАННЯ 12: Перевірка унікальності значень у Map

    public boolean isUnique(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return true;
        }
        Set<String> uniqueValues = new HashSet<>();
        for (String value : map.values()) {
            if (!uniqueValues.add(value)) {
                return false;
            }
        }
        return true;
    }


    // ЗАВДАННЯ 13: Перетин двох Map

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();
        if (map1 == null || map2 == null) return result;
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey()) && map2.get(entry.getKey()).equals(entry.getValue())) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }


    // ЗАВДАННЯ 14: Зміна місцями ключів та значень

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> result = new HashMap<>();
        if (map == null) return result;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }
        return result;
    }


    // ЗАВДАННЯ 15: Найрідкісніше значення у Map

    public int rarest(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            return 0;
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (Integer value : map.values()) {
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
        }

        Integer rarestValue = null;
        int minFrequency = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int value = entry.getKey();
            int freq = entry.getValue();

            if (freq < minFrequency) {
                minFrequency = freq;
                rarestValue = value;
            } else if (freq == minFrequency) {
                if (rarestValue == null || value < rarestValue) {
                    rarestValue = value;
                }
            }
        }

        return rarestValue != null ? rarestValue : 0;
    }


    // ЗАВДАННЯ 16: Максимальна кількість входжень

    public int maxOccurrences(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }

        Map<Integer, Integer> counts = new HashMap<>();
        int maxCount = 0;

        for (Integer n : list) {
            int count = counts.getOrDefault(n, 0) + 1;
            counts.put(n, count);
            if (count > maxCount) {
                maxCount = count;
            }
        }

        return maxCount;
    }
}