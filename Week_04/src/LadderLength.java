import java.util.*;

/**
 * @author zhouyp
 * @program leecodetraing
 * @description
 * @create 2020-07-19
 */
public class LadderLength {

	public static void main(String[] args) {
		final String beginWord = "hit";
		final String endWord = "cog";
		List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
		System.out.println(buildAllCombDict(wordList));

		System.out.println(ladderLength(beginWord, endWord, wordList));
	}

	static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		final Map<String, List<String>> dict = buildAllCombDict(wordList);
		final Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(beginWord, 1));

		Set<String> visited = new HashSet<>();
		visited.add(beginWord);

		while (!queue.isEmpty()) {
			final Pair pair = queue.poll();
			final String word = pair.key;
			final int level = pair.value;
			for (int i = 0; i < beginWord.length(); i++) {
				final String newWord = getTaggedWord(word, i);
				final List<String> adjacentWordList = dict.get(newWord);
				if (adjacentWordList == null || adjacentWordList.size() == 0) continue;
				for (String adjacentWord : adjacentWordList) {
					if (adjacentWord.equals(endWord)) {
						return level + 1;
					}
					if (!visited.contains(adjacentWord)) {
						visited.add(adjacentWord);
						queue.add(new Pair(adjacentWord, level + 1));
					}
				}
			}
		}
		return 0;
	}

	private static Map<String, List<String>> buildAllCombDict(List<String> wordList) {
		final Map<String, List<String>> dict = new HashMap<>();
		for (final String word : wordList) {
			for (int j = 0; j < word.length(); j++) {
				final String newWord = getTaggedWord(word, j);
				final List<String> list = dict
						.getOrDefault(newWord, new ArrayList<>());
				list.add(word);
				dict.put(newWord, list);
			}
		}
		return dict;
	}

	private static String getTaggedWord(String word, int index) {
		return word.substring(0, index) + "*" + word.substring(index + 1);
	}

	private static class Pair {
		String key;
		int value;

		Pair(String key, int value) {
			this.key = key;
			this.value = value;
		}
	}
}
