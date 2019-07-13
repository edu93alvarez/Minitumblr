package pe.mambo.ahorakotlin.presentation.base

interface MTBaseView<T> {

    val presenter: T

    fun showProgressLoading()

    fun hideProgressLoading()

}
