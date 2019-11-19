package co.betterup.betterfeed.constant


/**
This class allows us to reuse the same adapter for both our main and favorite article feeds.
 By passing in a FEEDTYPE to the adapter's constructor, we can request that it behaves in specific ways.
 */
enum class FEEDTYPE {MAIN, FAVORITES}