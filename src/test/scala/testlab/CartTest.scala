package testlab


import org.scalatest.{BeforeAndAfter, FlatSpec, FunSuite}

class BsaicCartTest extends FunSuite with BeforeAndAfter{
  var cart: Cart = _

  before {
    cart = new BasicCart()
  }

  test("A new cart must be empty") {
      assert(cart.content.isEmpty)
  }

  test("Adding a product increase size") {
      cart.add(new Item(new Product("Banane"), new ItemDetails(2, new Price(2.40))))
      assert(cart.size == 1)
  }

  test("Adding two product of the same type doubles the price") {
    cart.add(new Item(new Product("Banane"), new ItemDetails(2, new Price(2.40))))
    cart.add(new Item(new Product("Banane"), new ItemDetails(2, new Price(2.40))))
    assert(cart.totalCost == 4.80)
  }
}

class BasicCatalogTest extends FlatSpec with BeforeAndAfter {
  var catalog: Catalog = _

    before {
      catalog = new BasicCatalog(Map())
    }

    "An empty catalog" should "Have size 0" in {
      assert(catalog.products.isEmpty)
    }

    it should "Throw an excpetion" in {
      assertThrows[NoSuchElementException] {
        catalog.priceFor(new Product("Banana"))
      }
    }

    "A catalog with a product (Banana) with cost 2.30" should "Have one element" in {
      catalog = new BasicCatalog(Map(new Product("Banana") -> new Price(2.30)))
      assert(catalog.products.size == 1)
    }

    it should "Find the product" in {
      catalog = new BasicCatalog(Map(new Product("Banana") -> new Price(2.30)))
      assert(catalog.products.head._2.value == 2.30)
    }
}

