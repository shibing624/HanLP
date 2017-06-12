package com.hankcs.error;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.Other.AhoCorasickDoubleArrayTrieSegment;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;
import org.junit.Test;

import java.util.List;

/**
 * @author XuMing
 */
public class CustomDictionaryTest {
    @Test
    public void numTest() {
        String[] testCase = new String[]{
            "RAV42016款豪华汽车。",
        };
//        HanLP.Config.enableDebug();
        Segment segment = HanLP.newSegment().enableCustomDictionary(true).enableNameRecognize(false).enableAllNamedEntityRecognize(false);
        for (String sentence : testCase) {
            List<Term> termList = segment.seg(sentence);
            System.out.println(termList);
        }

        // AhoCorasickDoubleArrayTrieSegment要求用户必须提供自己的词典路径
        AhoCorasickDoubleArrayTrieSegment segment1 = new AhoCorasickDoubleArrayTrieSegment()
            .loadDictionary(HanLP.Config.CustomDictionaryPath[0]);
        System.out.println(segment1.seg("循环经济RAV42016款"));
    }
}
