package net.fiive;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

public class HiraganaTranslator {

	Map<String,Integer> hiraganaMap;

	public HiraganaTranslator() {
		hiraganaMap = Maps.newHashMap();
		hiraganaMap.put("a", R.string.a);
		hiraganaMap.put("i", R.string.i);
		hiraganaMap.put("u", R.string.u);
		hiraganaMap.put("o", R.string.o);
		hiraganaMap.put("e", R.string.e);
		hiraganaMap.put("ka", R.string.ka);
		hiraganaMap.put("ki", R.string.ki);
		hiraganaMap.put("ko", R.string.ko);
		hiraganaMap.put("ku", R.string.ku);
		hiraganaMap.put("kya", R.string.kya);
		hiraganaMap.put("kyo", R.string.kyo);
		hiraganaMap.put("kyu", R.string.kyu);
		hiraganaMap.put("ya", R.string.ya);
		hiraganaMap.put("yo", R.string.yo);
		hiraganaMap.put("yu", R.string.yu);
		hiraganaMap.put("sa", R.string.sa);
		hiraganaMap.put("shi", R.string.shi);
		hiraganaMap.put("su", R.string.su);
		hiraganaMap.put("se", R.string.se);
		hiraganaMap.put("so", R.string.so);
	}

	public Optional<Integer> translateToHiragana(String text) {
		Preconditions.checkNotNull(text, "Error: Text cannot be null");
		if ( hiraganaMap.containsKey(text)) {
			return Optional.of(hiraganaMap.get(text));
		} else {
			return Optional.absent();
		}
	}


}
