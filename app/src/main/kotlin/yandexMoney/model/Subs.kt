package yandexMoney.model

class Subs (
        val id: Int,
        val title: String,
        val subs: List<InternalSubs>)



    //    override fun writeToParcel(dest: Parcel, flags: Int) {
    //        dest.writeInt(id)
    //        dest.writeString(title)
    //        dest.writeList(subs)
    //    }
    //
    //    override fun describeContents(): Int = 0
    //
    //
    //    val creator : Parcelable.Creator<Subs> = object : Parcelable.Creator <Subs> {
    //
    //        override fun newArray(size: Int): Array<out Subs>? {
    //            return Array(size, { i -> Subs(id, title, subs)})
    //        }
    //
    //        override fun createFromParcel(source: Parcel): Subs? {
    //            return Subs(source.readInt(),
    //                    source.readString(), source.readList(subs, javaClass<InternalSubs>().getClassLoader())
    //            //source.currentClass
    //        }
    //    }
